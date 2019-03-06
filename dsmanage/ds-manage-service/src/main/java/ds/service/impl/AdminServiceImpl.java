package ds.service.impl;

import ds.common.pojo.Result;
import ds.mapper.AdminMapper;
import ds.pojo.Admin;
import ds.pojo.AdminExample;
import ds.service.AdminService;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Value("${PRIVATEKEY}")
    private String privateKeyStr;

    private static RSAPrivateKey privateKey;

    @Override
    public Result addAdmin(Admin admin) throws Exception{
        if (admin.getAdminName()==null||admin.getAdminPassword()==null){
            return new Result(Result.Status.emptyParam,"empty name or password");
        }
        admin.setAdminId(null);
        admin.setValued(null);
        String password=admin.getAdminPassword();

        //解密
        admin.setAdminPassword(decrypt(admin.getAdminPassword()));


        Integer num=adminMapper.insertSelective(admin);
        if (num==0){
            return new Result(Result.Status.somethingWrong,"insert fail");
        }
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result delAdmin(Long id) {
        if (id==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }
        Admin admin=new Admin();
        admin.setValued(false);
        admin.setAdminId(id);
        Integer num=adminMapper.updateByPrimaryKeySelective(admin);
        if (num==0){
            return new Result(Result.Status.somethingWrong,"del fail");
        }
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result updateAdmin(Admin admin) throws Exception {
        if (admin.getAdminId()==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }
        admin.setValued(null);

        //解密
        admin.setAdminPassword(decrypt(admin.getAdminPassword()));


        Integer num=adminMapper.updateByPrimaryKeySelective(admin);
        if (num==0){
            return new Result(Result.Status.somethingWrong,"update fail");
        }
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result searchAdmin(Admin admin) {
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria=adminExample.createCriteria();
        if (admin.getAdminId()!=null){
            criteria.andAdminIdEqualTo(admin.getAdminId());
        }
        if (admin.getAdminName()!=null){
            criteria.andAdminNameLike(admin.getAdminName());
        }
        List<Admin> list=adminMapper.selectByExample(adminExample);
        for (Admin result:list){
            result.setAdminPassword(null);
        }
        return new Result(Result.Status.success,"success",list);
    }

    private String decrypt(String password) throws Exception{
        //解密
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher=Cipher.getInstance("RSA/None/PKCS1Padding","BC");
        KeyFactory keyFactory=KeyFactory.getInstance("RSA","BC");
        if (privateKey==null) {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] buffer = base64Decoder.decodeBuffer(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            privateKey=(RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        }
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        return new String(cipher.doFinal(password.getBytes()));
    }
}
