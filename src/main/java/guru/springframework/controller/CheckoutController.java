package guru.springframework.controller;

import guru.springframework.command.CheckoutCommand;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CheckoutController {

    @RequestMapping("checkout")
    private String checkoutForm() {
        return "checkoutForm";
    }

    @RequestMapping(value = "/docheckout", method = RequestMethod.POST)
    public String doCheckout(@Valid CheckoutCommand checkoutCommand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "checkoutForm";
        }
        return "checkoutComplete";
    }
}
