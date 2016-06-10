package cn.boxfish.repeat.web;

import cn.boxfish.repeat.entity.SubmitForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Random;

/**
 * Created by LuoLiBing on 16/5/26.
 */
@Controller
public class DuplicateFormSubmission {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultView(HttpServletRequest request, Model model) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if(inputFlashMap != null) {
            model.addAttribute("formResults", inputFlashMap.get("submitForm"));
        }
        return "index";
    }

    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public RedirectView handlePost(HttpServletRequest request,
                                   @ModelAttribute SubmitForm submitForm,
                                   RedirectAttributes redirectAttrs) {

        Random random = new Random(10);
        submitForm.setConfirmationNumber(random.nextInt(10));

        redirectAttrs.addFlashAttribute(submitForm);

        return new RedirectView("/", true);
    }
}
