package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.entities.Roles;
import com.example.demo.repositories.AccountRepositoy;
import com.example.demo.repositories.RolesRepository;
import com.example.demo.utils.Log4jUtils;
import com.example.demo.vo.AccountVO;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	AccountRepositoy accountRepository;
	
	@Autowired
	RolesRepository roleRepository;


	@Override
	  public UserDetails loadUserByUsername(String username)
	      throws UsernameNotFoundException {
//	    Log4jUtils.getLogger().info("In UserDetailsService");

	    Account account = accountRepository.findByUserName(username);
//	    Log4jUtils.getLogger().info("Account id : "+account.getAccountID());

	    if (account == null) {
	      Log4jUtils.getLogger().info("User are null......");
	      throw new UsernameNotFoundException("User not found: " + username);
	    }

	    Roles role = roleRepository.findRoles(account.getAccountID());
	    Log4jUtils.getLogger().info("Role is " + role.getRoleName());

	    GrantedAuthority grantedAuthority;

	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

	    if (role != null) {
	      grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
	      Log4jUtils.getLogger().info("get authy: "+grantedAuthority.getAuthority());
	      grantedAuthorities.add(grantedAuthority);
	    }
	    Log4jUtils.getLogger().info("granted size : " + grantedAuthorities.size());
	    AccountVO accountVo = new AccountVO(account.getPassword(),
	        account.getUserName(), grantedAuthorities);

	    return accountVo;
	  }
}
