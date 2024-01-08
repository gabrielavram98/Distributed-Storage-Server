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


            RequestHandler handler= new RequestHandler();
            return handler.Handle(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
    @PostMapping("/api/server2")
    public HttpStatus Input2(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.Handle(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server3")
    public HttpStatus Input3(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.Handle(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server4")
    public HttpStatus Input4(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.Handle(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server5")
    public HttpStatus Input5(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.Handle(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
    @PostMapping("/api/server6")
    public HttpStatus Input6(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.Handle(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server7")
    public HttpStatus Input7(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.Handle(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
    @PostMapping("/api/server8")
    public HttpStatus Input8(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);

            RequestHandler handler= new RequestHandler();
            return handler.Handle(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }




}
