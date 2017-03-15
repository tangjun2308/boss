package com.tangjun.boss.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
        // �����uri
        String uri = request.getRequestURI();
  
        // uri�а���backgroundʱ�Ž��й���
        if (uri.indexOf(".do") != -1) {
            // ִ�й���
            // ��session�л�ȡ��¼��ʵ��
            Object obj = request.getSession().getAttribute("user");
            if (null == obj) {
                // ���session�в����ڵ�¼��ʵ�壬�򵯳�����ʾ���µ�¼
                // ����request��response���ַ�������ֹ����
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                String loginPage = "....";
                StringBuilder builder = new StringBuilder();
                builder.append("<script type=\"text/javascript\">");
                builder.append("alert('��ҳ���ڣ������µ�¼��');");
                builder.append("window.top.location.href='");
                builder.append(loginPage);
                builder.append("';");
                builder.append("</script>");
                out.print(builder.toString());
            } else {
                // ���session�д��ڵ�¼��ʵ�壬�����
                filterChain.doFilter(request, response);
            }
        } else {
            // ���uri�в�����.do�������
            filterChain.doFilter(request, response);
        }
    }

}