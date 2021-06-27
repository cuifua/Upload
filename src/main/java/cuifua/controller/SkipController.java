package cuifua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("skip")
public class SkipController
{
    @RequestMapping("index")
    public String index()
    {
        return "index";
    }
}
