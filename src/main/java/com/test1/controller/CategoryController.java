package com.test1.controller;

import com.test1.entity.Category;
import com.test1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用@RestController注解取代@Controller注解，作用是默认将所有方法标识@ResponseBody注解返回json数据给前端。
 * 如果想让个别方法返回json可以在类上注解普通的@Controller，方法上单独注解@ResponseBody。
 * （Springboot的web-starter已经集成了json的相关包无用额外添加依赖）
 *
 * 用@GetMapping，@DeleteMapping，@PutMapping和@PostMapping取代@RequestMapping
 * 相当于增加了method=“GET”等内容，根据请求方法映射到不同的方法。
 * 这就是Springboot开启Restful的基本思路
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //获取
    @GetMapping("/getAll")
    public List<Category> list() {
        List<Category> categories = categoryService.findAll();
        return categories;
    }

    //获取
    @GetMapping("/get/{id}")
    public Category getCategory(@PathVariable("id") int id) {
        Category category = categoryService.findById(id);
        return category;
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.delete(id);
        return "true";
    }

    //添加
    @PutMapping("/add")
    public String addCategory(Category category) {
        categoryService.add(category);
        return "true";
    }

    //修改
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") int id, Category category) {
        Category category1 = categoryService.findById(id);
        category1.setName(category.getName());
        categoryService.update(category1);
        return "true";
    }

    /**
     * 用@RestController默认将所有方法标识@ResponseBody注解,
     * 返回值类型为String时，默认解析成json，
     * 所以如果要跳转到某个页面，需要返回ModelAndView。
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public ModelAndView editCategory(@PathVariable("id") int id) {
        Category category = categoryService.findById(id);
        ModelAndView mv = new ModelAndView("categoryEdit");
        mv.addObject("category", category);
        return mv;
    }

}
