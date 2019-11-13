package com.yoona;

import com.yoona.dao.StarMapper;
import com.yoona.dao.TbBrandMapper;
import com.yoona.entity.QueryVo;
import com.yoona.entity.Star;
import com.yoona.entity.TbBrand;
import com.yoona.util.PageBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest(classes = Application.class)
class ApplicationTests {

    @Autowired
    private StarMapper starMapper;

    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
     * 查询所有品牌
     */
    @Test
    void getAllBrand(){
        List<TbBrand> lists = tbBrandMapper.selectAll();
        lists.forEach(l ->{
            System.out.println(l);
        });
    }

    /**
     * 查询所有
     */
    @Test
    void contextLoads() {
        welcome();
        List<Star> list = starMapper.selectAll();
        list.forEach(n -> {
            System.out.println(n.toString());
        });
    }

    /**
     * 根据ID查询
     */
    @Test
    void selectById(){
        welcome();
        int id= 2;
        Star star = starMapper.selectByPrimaryKey(id);
        System.out.println(star);
    }

    /**
     * 根据名称查询
     */
    @Test
    void selectByName(){
        welcome();
        String name = "成龙";
        List<Star> stars = starMapper.selectByName(name);
       stars.forEach(star -> {
           System.out.println(star);
       });
    }

    /**
     * 模糊查询
     */
    @Test
    void selectByLike(){
        welcome();
        List<Star> stars = starMapper.selectByLike("李");
        stars.forEach(star -> {
            System.out.println(star);
        });
    }

    /**
     * 多条件查询方法一（传实体）
     */
    @Test
    void selectByCondition(){
        welcome();
        Star s = new Star();
        s.setMovie("精武门");
        s.setStarName("李小龙");
        Star star = starMapper.selectByCondition(s);
        System.out.println(star);
    }

    /**
     * 多条件查询方法一（传参数）
     */
    @Test
    void selectByConditions(){
        welcome();
        Star star = starMapper.selectByConditions("李小龙","精武门");
        System.out.println(star);
    }

    /**
     * 查询单独的两列信息，名字，电影(方法一)
     */
    @Test
    void selectSomeInfo(){
        welcome();
        List<Star> stars = starMapper.selectSomeInfo();
        stars.forEach(star -> {
            System.out.println("{"+star.getStarName()+","+star.getMovie()+"}");
        });
    }

    /**
     * 查询单独的两列信息，名字，电影(方法二)
     */
    @Test
    void selectByQueryVo(){
        welcome();
        List<QueryVo> lists = starMapper.selectByQueryVo();
        lists.forEach(list ->{
            System.out.println(list);
        });
    }


    /**
     * 添加
     */
    @Test
    void addTests() {
        welcome();
        Star star = new Star();
        Date now = new Date();
        star.setStarName("李连杰");
        star.setStarSex(1);
        star.setMovie("黄飞鸿");
        star.setCreated(now);
        star.setUpdated(now);
        int n = starMapper.insert(star);
        if(n == 1) {
            System.out.println("添加成功*****************************");
        } else {
            System.out.println("添加失败*****************************");
        }
    }

    /**
     * 修改
     */
    @Test
    void updateTests() {
        welcome();
        int id = 3; // 开发时，这个id是从前台传过来的
        Star star = starMapper.selectByPrimaryKey(id);
        Date now = new Date();
        star.setMovie("少林寺"); // 设置修改的数据
        star.setUpdated(now);
        int n = starMapper.updateByPrimaryKey(star);
        if(n == 1) {
            System.out.println("修改成功*****************************");
        } else {
            System.out.println("修改失败*****************************");
        }
    }

    /**
     * 输出引导语
     */
    public void welcome() {
        System.out.println();
        System.out.println("   .  ._______.______. _____._______.__ _ _   ");
        System.out.println("  /\\\\ |__   __|  ____|/ ____|__   __|\\ \\ \\ \\  ");
        System.out.println(" ( ( )   | |  | |____/ /____   | |    \\ \\ \\ \\ ");
        System.out.println("  \\\\/    | |  |  ____| '___ \\  | |     ) ) ) )");
        System.out.println("   '     | |  | |____._____) | | |    / / / / ");
        System.out.println("  =======|_|==|______.\\_____/==|_|===/_/ /_/  ");
        System.out.println("  :: Spring Test ::            (v2.1.3.RELEASE)");
        System.out.println();
    }

}
