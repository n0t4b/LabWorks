package com.example.lab3.controller;

import com.example.lab3.model.Call;
import com.example.lab3.repository.CallDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/calls")
public class CallController {

    @Autowired
    private CallDAO callDAO;

    @GetMapping
    public String getAllCalls(Model model) {
        List<Call> calls = callDAO.getAllCalls();
        model.addAttribute("calls", calls);
        return "call/list";
    }

    @GetMapping("/export")
    public String exportCalls() throws IOException {
        callDAO.writeCallsToFile("calls.txt");
        return "redirect:/calls";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("call", new Call());
        return "call/add";
    }

    @PostMapping("/add")
    public String addCall(@ModelAttribute Call call) {
        callDAO.addCall(call);
        return "redirect:/calls";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Call call = callDAO.findCallById(id);
        model.addAttribute("call", call);
        return "call/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateCall(@PathVariable("id") int id, @ModelAttribute Call call) {
        call.setCallID(id);
        callDAO.updateCall(call);
        return "redirect:/calls";
    }

    @GetMapping("/delete/{id}")
    public String deleteCall(@PathVariable("id") int id) {
        callDAO.deleteCall(id);
        return "redirect:/calls";
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "call/search";
    }

    @PostMapping("/search")
    public String searchCalls(@RequestParam("subscriberNumber") String subscriberNumber, Model model) {
        List<Call> calls = callDAO.findCallsBySubscriberNumber(subscriberNumber);
        model.addAttribute("calls", calls);
        return "call/list";
    }
}