package proiectdiz.Storage.Senders;

import proiectdiz.Storage.Config.WebClientConfig;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Service.SenderService;

public class ShareSender extends Thread {
    private String share;



    public ShareSender(String share){
        this.share=share;

    }

    public void run(){


        WebClientConfig webconfig= new WebClientConfig();
        SenderService sender= new SenderService( webconfig.webClientBuilder());
        String response=sender.sendJsonToReceiver(share, "/gatherShares");
        System.out.println(response);
        Log.InfoLog(response);

    }

}