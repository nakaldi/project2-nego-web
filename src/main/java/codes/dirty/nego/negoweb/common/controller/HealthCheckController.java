package codes.dirty.nego.negoweb.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> isRunning() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("status", "UP");

        return ResponseEntity.ok(resultMap);
    }


}
