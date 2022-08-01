package com.fw.template.board.controller;

import com.fw.template.board.model.Board;
import com.fw.template.board.repository.BoardRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@RequestMapping("/board")
@Api(value="BoardController Swagger", tags = "BoardController")
@RestController
public class BoardController {

    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/lists")
    @ApiOperation(value = "lists")
    public String getList() {

        //Page<Board> lists = boardRepository.findAll();
        List lists = boardRepository.findAll();



        return lists.toString();
    }

    @GetMapping("/list/{id}")
    @ApiOperation(value = "list")
    public String getListById(@PathVariable String id)  {
        //Page<Board> lists = boardRepository.findAll();
        Optional lists = boardRepository.findById(id);

        return lists.toString();
    }
}