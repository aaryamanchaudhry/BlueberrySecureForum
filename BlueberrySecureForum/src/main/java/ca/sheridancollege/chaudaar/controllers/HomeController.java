package ca.sheridancollege.chaudaar.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.chaudaar.beans.Post;
import ca.sheridancollege.chaudaar.beans.User;
import ca.sheridancollege.chaudaar.repositories.PostRepository;
import ca.sheridancollege.chaudaar.repositories.RoleRepository;
import ca.sheridancollege.chaudaar.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PostRepository postRepository;

	private String encodePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}


	@GetMapping("/user/check")
	public String check() {
		return "user/check";
	}

	@GetMapping("/user")
	public String userIndex(Model model, Authentication authentication, @ModelAttribute Post post) {

		String name = authentication.getName();
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority ga : authentication.getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		model.addAttribute("name", name);
		model.addAttribute("roles", roles);

		List<Post> postlist = postRepository.findAll();
		model.addAttribute("postlist", postlist);
		model.addAttribute("roles", roles);
		model.addAttribute("post", new Post());

		return "user/index";
	}

	@GetMapping("/searchByTopic")
	public String searchTopic(Model model, @RequestParam String topic, Authentication authentication) {

		String name = authentication.getName();
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority ga : authentication.getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		model.addAttribute("name", name);
		model.addAttribute("roles", roles);
		model.addAttribute("post", new Post());

		List<Post> postlist = postRepository.findByPosttopic(topic);
		model.addAttribute("postlist", postlist);

		return "user/index";
	}

	@GetMapping("/searchByTitle")
	public String searchTitle(Model model, @RequestParam String title, Authentication authentication) {

		String name = authentication.getName();
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority ga : authentication.getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		model.addAttribute("name", name);
		model.addAttribute("roles", roles);
		model.addAttribute("post", new Post());
		List<Post> postlist = postRepository.findByPosttitle(title);
		model.addAttribute("postlist", postlist);

		return "user/index";
	}


	@GetMapping("/error/access-denied")
	public String accessDenied() {
		return "error/access-denied";
	}

	@GetMapping("/register")
	public String goRegistration() {
		return "register";
	}

	@PostMapping("/register")
	public String doRegistration(@RequestParam String username, @RequestParam String password) {
		User user = new User(username, encodePassword(password), Byte.valueOf("1"));
		user.getRoles().add(roleRepository.findByRolename("ROLE_USER"));
		userRepository.save(user);

		return "redirect:/";
	}

	@PostMapping("/addPost")
	public String insertPost(Model model, @ModelAttribute Post post, Authentication authentication) {

		User user = userRepository.findByUsername(authentication.getName());

		Post temp = postRepository.save(post);
		user.getPostList().add(temp);
		userRepository.save(user);
		model.addAttribute("postlist", postRepository.findAll());
		model.addAttribute("post", new Post());

		return "user/index";
	}

}
