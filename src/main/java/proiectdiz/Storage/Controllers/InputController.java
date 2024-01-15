package proiectdiz.Storage.Controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.RequestHandler;

@RestController
public class InputController {

    @PostMapping("/api/server1/store")
    public HttpStatus Input(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
    @PostMapping("/api/server2/store")
    public HttpStatus Input2(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server3/store")
    public HttpStatus Input3(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server4/store")
    public HttpStatus Input4(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server5/store")
    public HttpStatus Input5(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
    @PostMapping("/api/server6/store")
    public HttpStatus Input6(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server7/store")
    public HttpStatus Input7(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);


            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
    @PostMapping("/api/server8/store")
    public HttpStatus Input8(@RequestBody String requestBody) {
        try{
            Log.ErrorLog(requestBody);

            RequestHandler handler= new RequestHandler();
            return handler.HandleStoreRequest(requestBody);
        }
        catch(Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @PostMapping("/api/server1/get")
    public HttpStatus Output1(@RequestBody String requestBody){
        try{
            RequestHandler handler= new RequestHandler();
            return handler.HandleGetRequest(requestBody);

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }




}
