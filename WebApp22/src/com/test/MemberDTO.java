package com.test;

public class MemberDTO
{
	private String name;      
	private String tel;       
	private String addr;
	
	/*
	 insert 에서
	for(int i=1; i<6; i++)
	{
		MemberDTO dto = new MemberDTO();
		
		dto.setName(request.getParameter("name" + i));
		dto.setTel(request.getParameter("tel"+ i));
		dto.setAddr(request.getParameter("addr"+ i));
		
		lists.add(dto);
	} 
	이렇게 처리 할 꺼라서  MemberDTO()
	 */
	public MemberDTO()
	{
		
	}
	
	/*
	 insert 에서
	 
	 Member DTO;
	for(int i=1; i<6; i++)
	{
		dto = new MemberDTO(request.getParameter("name" + i)
		,request.getParameter("tel"+ i),request.getParameter("addr"+ i));
	
		lists.add(dto);
	} 
	이렇게 한번에 하려면 요렇게 해야함
	
	public MemberDTO(String name, String tel, String addr)
	{
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	 */
	
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getAddr()
	{
		return addr;
	}
	public void setAddr(String addr)
	{
		this.addr = addr;
	}     
	
}
