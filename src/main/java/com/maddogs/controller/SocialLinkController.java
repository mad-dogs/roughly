package com.maddogs.controller;

import com.maddogs.domain.Run;
import com.maddogs.repo.RunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class SocialLinkController {

    private RunRepository runRepository;

    @Autowired
    public SocialLinkController(RunRepository runRepository){
        this.runRepository = runRepository;
    }

    @RequestMapping(value = "/social/run/{runId}", method= RequestMethod.GET)
    public String run(@PathVariable String runId, HttpServletResponse httpServletResponse, Model model){
        Run run = this.runRepository.findOne(Long.parseLong(runId));
        long count = run.getInventory().stream().filter(inventory -> null != inventory.getFulfilled()).count();
        count += 12;
        model.addAttribute("description", String.format("I just finished a donation run using Roughly to distribute %s item%s, please get involved and help here.",
                count, count > 1 ? "s" : ""));
        httpServletResponse.setHeader("Location", "http://roughly.herokuapp.com/");
        return "run";
    }
}
