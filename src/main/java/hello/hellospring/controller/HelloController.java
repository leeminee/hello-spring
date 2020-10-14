package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/** //@ResponseBody
 *  : return 값에 문자열이면 ViewResolver가 문자열 그대로 반환
 *  : return 값에 객체가 오면 HttpMessageConverter가 Json 형식으로 반환
 *
 */
@Controller
public class HelloController {

    // /hello 가 들어오면 해당 메소드 실행
    // return 은 기본설정이 resources/templates 하위에 hello 파일을 찾아서 렌더링 되도록 설정 되어있다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 소스보기 했을때 html 태그없이 return 문자열 그대로 출력
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody // return 에 객체가 있으면 json 형식으로 반환됨
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
