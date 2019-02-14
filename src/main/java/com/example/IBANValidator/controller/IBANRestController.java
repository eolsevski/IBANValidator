package com.example.IBANValidator.controller;

import com.example.IBANValidator.model.Iban;
import com.example.IBANValidator.model.IbanWrapper;
import com.example.IBANValidator.service.IbanValidationService;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class IBANRestController {

    private IbanValidationService ibanValidationService = new IbanValidationService();

    /**
     * controller for validating arrays from ibans, support json
     * @param wrapper
     * @return
     */

    @PostMapping("/validate")
    public IbanWrapper ibanValidator(@RequestBody IbanWrapper wrapper) {
                wrapper
                .getIbanNumbers()
                .stream()
                .filter((x) ->ibanValidationService.validate(x.getIban()))
                .forEach(u->u.setValid(true));
        return wrapper;
    }

    /**
     * controller for validating single iban from browser address bar
     * @param iban
     * @return
     */
    @PostMapping("/validate/{iban}")
    public boolean ibanValidatorOne(@PathVariable("iban") String iban) {
        return ibanValidationService.validate(iban);
    }

    /**
     * if lazy type it, just run this and copy for yourself
     * @return
     */
    @GetMapping("/format")
    public IbanWrapper faker() {
        Iban iban = new Iban();
        iban.setIban("AA051245445454552117989");
        Iban iban1 = new Iban();
        iban1.setIban("LT647044001231465456");
        Iban iban2 = new Iban();
        iban2.setIban("LT517044077788877777");
        Iban iban3 = new Iban();
        iban3.setIban("LT227044077788877777");
        Iban iban4 = new Iban();
        iban4.setIban("CC051245445454552117989");
        IbanWrapper ibanWrapper = new IbanWrapper();
        ibanWrapper.setIbanNumbers(Arrays.asList(iban, iban1, iban2, iban3));
        return ibanWrapper;
    }
}
