package hello0826.hello0826spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hi");
        return  "hello";
    }

    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam("name") String name2,Model model) {
        model.addAttribute("name",name2);
        Hello hello = new Hello();

        return "hello-template";
    }
//
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name ) {
        Hello hello =new Hello();
        hello.setName(name);
        System.out.println(hello.getName());
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void  setName(String name) {
            this.name =name;
        }
    }



}
