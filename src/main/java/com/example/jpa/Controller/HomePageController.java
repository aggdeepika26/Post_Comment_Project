package com.example.jpa.Controller;

import com.example.jpa.Service.PostService;
import com.example.jpa.Service.PostServiceImpl;
import com.example.jpa.model.Post;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomePageController {
    @Autowired
    private PostServiceImpl postService;


    @GetMapping({"/showPosts", "/", "/list"})
    public ModelAndView showPosts() {
        ModelAndView mav = new ModelAndView("index");
        List<Post> list = postService.getAllPost();
        mav.addObject("listPosts", list);
        return mav;
    }


    @GetMapping("/showNewPostForm")
    public ModelAndView showNewPostForm() {
        ModelAndView mav = new ModelAndView("new_post");
        Post newPost = new Post();
        mav.addObject("post", newPost);
        return mav;
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("post") Post post) {
        postService.savePost(post);
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdate")
    public ModelAndView showUpdateForm(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("update_post");
        Post post = postService.getPostById(id);
        mav.addObject("post", post);
        return mav;
    }


    @GetMapping("/deletePost")
    public String deletePost(@RequestParam Long id) {
        //call delete employee method
        this.postService.deletePostById(id);
        return "redirect:/";
    }

}





     /*  @GetMapping("/")
   public String viewHomePage(Model model)
    {
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";
    }*/



    /*  @GetMapping("/showNewEmployeeForm")
        public String showNewEmployeeForm(Model model)
      {
          Employee employee = new Employee();
          model.addAttribute("employee", employee);
          return "new_employee";
      }*/

/*  @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model) {
        //get employee from the services
        Employee employee = employeeService.getEmployeeById(id);
        //set employee as a model attribute to preopulate the form
        model.addAttribute("employee",employee);
        return  "update_employee";
    }*/




  /*  @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id)
    {
        //call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }*/



