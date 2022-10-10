package com.controller.tutor;

import com.dto.member.MemberDTO;
import com.dto.tutor.TutorDTO;
import com.service.tutor.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class TutorController {


    private final TutorService tutorService;


    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }


    public static final String IMAGE_PATH = "/ogo/images/tour";


    @GetMapping("/tutor/register")
    public String register(HttpSession session, Model model) {

        model.addAttribute("profile", IMAGE_PATH + "/profile.jpeg");
        return "/tutor/tutor";
    }

    @PostMapping("/tutor/register")
    public String postRegister(HttpSession session,
                               @ModelAttribute TutorCreateForm form,
							   RedirectAttributes red,
							   HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
        MemberDTO dto2 = (MemberDTO) session.getAttribute("login");
        form.setUserid(dto2.getUserId());
        try {
            tutorService.storeFile(form.tutorimg,form.tcertificate);
        } catch (IOException e) {
            return "/error/error500";
        }
   
        if (tutorService.createTutor(form.toEntity()) == 1) {
            red.addFlashAttribute("flag", dto2.getUserId() +"님 튜터등록성공");
        }
        return "redirect:/tutor/register";
    }


    static class TutorCreateForm {

        public TutorCreateForm() {
        }


        @Override
        public String toString() {
            return "TutorCreateForm{" +

                    ", tname='" + tname + '\'' +

                    ", tcategory_id='" + tcategory_id + '\'' +
                    ", tintroduce='" + tintroduce + '\'' +
                    ", userid='" + userid + '\'' +
                    '}';
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public void setTcategory_id(String tcategory_id) {
            this.tcategory_id = tcategory_id;
        }

        public void setTintroduce(String tintroduce) {
            this.tintroduce = tintroduce;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public void setTutorimg(MultipartFile tutorimg) {
            this.tutorimg = tutorimg;
        }

        public void setTcertificate(MultipartFile tcertificate) {
            this.tcertificate = tcertificate;
        }

        public String getTname() {
            return tname;
        }

        public String getTcategory_id() {
            return tcategory_id;
        }

        public String getTintroduce() {
            return tintroduce;
        }

        public String getUserid() {
            return userid;
        }

        public MultipartFile getTutorimg() {
            return tutorimg;
        }

        public MultipartFile getTcertificate() {
            return tcertificate;
        }

        private String tname;
        private String tcategory_id;
        private String tintroduce;
        private String userid;
        private MultipartFile tutorimg;
        private MultipartFile tcertificate;



        public TutorDTO toEntity() {
            TutorDTO tutorDTO = new TutorDTO();
            tutorDTO.setTname(this.tname);
            tutorDTO.setUserid(this.userid);
            tutorDTO.setTcertificate(this.tcertificate.getOriginalFilename());
            tutorDTO.setTimg(this.tutorimg.getOriginalFilename());
            tutorDTO.setTcategory_id(this.tcategory_id);
            tutorDTO.setTintroduce(this.tintroduce);
            return tutorDTO;
        }
    }


}
