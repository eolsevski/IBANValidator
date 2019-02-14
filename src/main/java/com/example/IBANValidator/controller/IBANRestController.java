package com.example.IBANValidator.controller;

import com.example.IBANValidator.model.Iban;
import com.example.IBANValidator.model.IbanWrapper;
import com.example.IBANValidator.service.IbanValidationService;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class IBANRestController {

    IbanValidationService ibanValidationService = new IbanValidationService();

    @PostMapping("/validate")
    public IbanWrapper ibanValidator(@RequestBody IbanWrapper wrapper) {
                wrapper
                .getIbanNumbers()
                .stream()
                .filter((x) ->ibanValidationService.validate(x.getIban()))
                .forEach(u->u.setValid(true));
        return wrapper;
    }
    @PostMapping("/validate/{iban}")
    public boolean ibanValidatorOne(@PathVariable("iban") String iban) {
        return ibanValidationService.validate(iban);
    }

//this part for testing only, remove after coding
    @GetMapping("/format")
    public IbanWrapper faker() {
        Iban iban = new Iban();
        iban.setIban("LT647044001231465456");
        Iban iban1 = new Iban();
        iban1.setIban("AA051245445454552117989");
        IbanWrapper ibanWrapper = new IbanWrapper();
        ibanWrapper.setIbanNumbers(Arrays.asList(iban, iban1));
        return ibanWrapper;
    }
}
