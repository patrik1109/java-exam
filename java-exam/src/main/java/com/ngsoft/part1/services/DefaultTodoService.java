package com.ngsoft.part1.services;

import com.ngsoft.part1.dao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

/**
 * This emulates a service layer that performs data statistics on a data source of {@link com.ngsoft.part1.pojos.TodoItem}s.
 * Whomever is going to consume this service (emulated here by unit test) is not going to know of this specific implementation
 * it will only be aware of the interface {@link TodoService}
 * The data source here is provided by an implementation of TodoDao interface that is already configured by spring.
 * please inject this spring bean.
 * For simplicity the only thing we need to do is to count items.
 * Please:
 * 1. Configure spring xml properly.
 * 2. Fix all the methods to work.
 * If you do both properly the TodoTest unit test will pass.
 *
 * Extra points for code reuse (hint: start with the hardest to implement).
 * Extra points for simple and readable code.
 */

//@ContextConfiguration(locations = "classpath:spring-config.xml")
@Service
public class DefaultTodoService implements TodoService {

    @Autowired
    TodoDao todoDao;

    @Override
    public long countAll() {
        long result = 0L;
        try {
            result = (long)todoDao.getTodos().size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public long countDone() {
        try {
            return todoDao.getTodos().stream().filter(td ->td.isCompleted()).collect(Collectors.counting());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long countItemsByUser(int userId) {
        try {

                return todoDao.getTodos().stream().filter(td -> {
                            return
                                    (td.getUserId()==userId);
                        }
                ).collect(Collectors.counting());

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long countFiltered(Integer userId, Boolean isDone, String filter) {

        try {

            if(userId==null) {
                return todoDao.getTodos().stream().filter(td -> td.getTitle().contains(filter)).collect(Collectors.counting());
            }
            else{
                return todoDao.getTodos().stream().filter(td -> {
                    return
                            (td.getUserId()==userId) &&
                                (td.getTitle().contains(filter))&&
                                    (td.isCompleted()==isDone);
                }
                        ).collect(Collectors.counting());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
