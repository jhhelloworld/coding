package a_test;


import java.io.Serializable;
import java.util.Date;

/**
 * IPS用户环境记录
 * 
 * @author qujianning
 *
 */
public class IpsEnvironment implements Serializable {

	private static final long serialVersionUID = 5243459071001721608L;

    /**
     * ID
     */
    private String id;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 学员业务系统ID
     */
    private String studentId;

    /**
     * IPS版本号
     */
    private String ipsVer;
    
    /**
     * IOS操作系统版本号
     */
    private String iosVer;
    
    /**
     * 设备型号
     */
    private String devModel;
    
    /**
     * 设备序列号
     */
    private String devId;
    
    /**
     * 设备IP地址
     */
    private String devIp;
    /**
     * 创建时间
     */
    private Date createTime = new Date();
	/**
	 * 修改时间
	 */
	private Date modifyTime = new Date();
    
    
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the ipsVer
	 */
	public String getIpsVer() {
		return ipsVer;
	}
	/**
	 * @param ipsVer the ipsVer to set
	 */
	public void setIpsVer(String ipsVer) {
		this.ipsVer = ipsVer;
	}
	/**
	 * @return the iosVer
	 */
	public String getIosVer() {
		return iosVer;
	}
	/**
	 * @param iosVer the iosVer to set
	 */
	public void setIosVer(String iosVer) {
		this.iosVer = iosVer;
	}
	/**
	 * @return the devModel
	 */
	public String getDevModel() {
		return devModel;
	}
	/**
	 * @param devModel the devModel to set
	 */
	public void setDevModel(String devModel) {
		this.devModel = devModel;
	}
	/**
	 * @return the devId
	 */
	public String getDevId() {
		return devId;
	}
	/**
	 * @param devId the devId to set
	 */
	public void setDevId(String devId) {
		this.devId = devId;
	}
	public String getDevIp() {
		return devIp;
	}
	public void setDevIp(String devIp) {
		this.devIp = devIp;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}


}
