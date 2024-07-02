package com.mem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mem.model.MemService;
import com.mem.model.MemVO;



//用於處理 RESTful API 請求,直接返回資料（例如 JSON、XML）。
//加上@ResponseBody 註解来返回資料
@RestController
@RequestMapping("/api")
public class RegistrationController {

	
	
	
	@Autowired
	private MemService memSvc;
	
//	註冊=============================================================================================
	//@RequestBody 是因為請求複雜
	@PostMapping("/register")
	 public ResponseEntity<String> registerMember(@Validated @RequestBody MemVO memVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 如果有驗證錯誤,將錯誤訊息返回前端
            StringBuilder errorMessage = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMessage.append(error.getDefaultMessage()).append("\n");
            });
            return ResponseEntity.status(400).body(errorMessage.toString());
        }

        try {
            memSvc.registerMember(memVO);
            return ResponseEntity.ok("註冊成功");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("註冊失敗：" + e.getMessage());
        }
    }
	
//	登入===============================================================================================
	@PostMapping("/login")
	public ResponseEntity<String> loginMember(@RequestBody MemVO memVO,HttpSession session){
		 try {
			 	//	確保只有經過驗證的用戶可以成功登入並訪問受保護的內容或功能
	            boolean isAuthenticated = memSvc.authenticateMember(memVO);
	            
	            if (isAuthenticated) {
	            	
//	            	MemService從服務層的方法,用email去獲取其他資料會員資訊賦值給 authenticatedMember 變數。
	            	 MemVO authenticatedMember = memSvc.getMemberByEmail(memVO.getMemEmail());
//	            	 然後將上一行的接收到的memVO物件存儲在session,使用"memVO"作為KEY
	            	 session.setAttribute("memVO", authenticatedMember);
//	            	session.setAttribute("memVO", memVO); 多餘的
	                return ResponseEntity.ok("登入成功");
	            } else {
	                return ResponseEntity.status(401).body("帳號或密碼錯誤");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("登入失敗：" + e.getMessage());
	        }
	    }
//	前端更新會員資料===============================================================================================


	
	
	@PutMapping("/updateMember")
	public ResponseEntity<String> updateMember(@RequestBody MemVO updatedMember, HttpSession session) {
	    try {
	        // 從Session中取得現有會員資訊
	        MemVO exMem = (MemVO) session.getAttribute("memVO");
	        
	        // 檢查是否有更新圖片，如果有，則更新
	        if (updatedMember.getUpFiles() != null && updatedMember.getUpFiles().length > 0) {
	            exMem.setUpFiles(updatedMember.getUpFiles());
	        }
	        
	        // 設定要更新的其他欄位值，排除memEmail欄位
	        exMem.setMemName(updatedMember.getMemName());
	        exMem.setMemEmail(updatedMember.getMemEmail());
	        exMem.setMemPassword(updatedMember.getMemPassword());
	        exMem.setMemAddress(updatedMember.getMemAddress());
	        exMem.setMemPhone(updatedMember.getMemPhone());
	        exMem.setMemUid(updatedMember.getMemUid());
	        exMem.setMemSex(updatedMember.getMemSex());
	        exMem.setMemDob(updatedMember.getMemDob());
	        
	        // 呼叫服務層進行更新
	        memSvc.updateMem(exMem);
	        
	        // 更新Session中的會員資訊
	        session.setAttribute("memVO", exMem);
	        
	        return ResponseEntity.ok("資料更新成功");
	    } catch (Exception e) {
	        return ResponseEntity.status(500).body("資料更新失敗：" + e.getMessage());
	    }
	}

	
	//測試圖片===============================================================================
	 @GetMapping("/memberImage/{memberId}")
	    public ResponseEntity<byte[]> getMemberImage(@PathVariable Integer memberId) {
	        byte[] imageData = memSvc.getMemberImage(memberId); // 從資料庫中獲取會員圖片資料
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_JPEG); // 設置返回類型為圖片類型，這裡假設是 JPEG
	        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
	    }
	
	
}
