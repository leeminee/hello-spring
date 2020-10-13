package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // /hello 가 들어오면 해당 메소드 실행
    // return 은 기본설정이 resources/templates 하위에 hello 파일을 찾아서 렌더링 되도록 설정 되어있다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}
