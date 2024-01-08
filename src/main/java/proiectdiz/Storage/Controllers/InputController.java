package proiectdiz.Storage.Controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.RequestHandler;

@RestController
public class InputController {

    @PostMapping("/api/server1")
    public HttpStatus Input(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            return RequestHandler.Handle(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }




    }
}
