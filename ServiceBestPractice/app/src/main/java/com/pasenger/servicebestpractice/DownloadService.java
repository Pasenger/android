package com.pasenger.servicebestpractice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import java.io.File;

public class DownloadService extends Service {

    private DownloadTask downloadTask;

    private String downloadUrl;

    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(1, getNofification("Downloading...", progress));
        }

        @Override
        public void onSuccess() {
            downloadTask = null;
            //下载成功时，前台服务通知关闭，并创建一个下载成功通知
            stopForeground(true);

            getNotificationManager().notify(1, getNofification("Download Success", -1));

            Toast.makeText(DownloadService.this, "Download Success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailed() {
            downloadTask = null;
            //下载成功时，前台服务通知关闭，并创建一个下载失败通知
            stopForeground(true);

            getNotificationManager().notify(1, getNofification("Download Failed", -1));

            Toast.makeText(DownloadService.this, "Download Failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            downloadTask = null;
            Toast.makeText(DownloadService.this, "Download Paused", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCanceled() {
            downloadTask = null;
            //下载成功时，前台服务通知关闭
            stopForeground(true);

            Toast.makeText(DownloadService.this, "Download Cancled", Toast.LENGTH_SHORT).show();
        }
    };

    private DownloadBinder downloadBinder = new DownloadBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return downloadBinder;
    }

    private NotificationManager getNotificationManager(){
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private Notification getNofification(String title, int progress){
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentIntent(pi);
        builder.setContentTitle(title);
        if(progress > 0){
            builder.setContentText(progress + "%");
            builder.setProgress(100, progress, false);
        }

        return builder.build();
    }

    class DownloadBinder extends Binder {

        public void startDownload(String url){
            if(downloadTask == null){
                downloadUrl = url;

                downloadTask = new DownloadTask(listener);
                downloadTask.execute(downloadUrl);

                startForeground(1, getNofification("Downloading...", 0));

                Toast.makeText(DownloadService.this, "Downloading...", Toast.LENGTH_SHORT).show();
            }
        }

        public void pauseDownload(){
            if(downloadTask != null){
                downloadTask.pauseDownload();
            }
        }

        public void cancelDownload(){
            if(downloadTask != null){
                downloadTask.cancelDownload();
            }else{
                if(downloadUrl != null){
                    //取消文件下载，并关闭通知
                    String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));

                    String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();

                    File file = new File(directory + fileName);
                    if(file.exists()){
                        file.delete();
                    }

                    getNotificationManager().cancel(1);

                    stopForeground(true);

                    Toast.makeText(DownloadService.this, "Canceled", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
}
