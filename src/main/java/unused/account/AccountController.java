//package unused.account;
//
//import java.security.Principal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.util.Assert;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@Secured("ROLE_USER")
//public class AccountController {
//
//    private final AccountRepository accountRepository;
//
//    @Autowired
//    public AccountController(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }
//
//    @RequestMapping(value = "account/current", method = RequestMethod.GET)
//    public Account accounts(Principal principal) {
//        Assert.notNull(principal);
//        return accountRepository.findByEmail(principal.getName());
//    }
//}
