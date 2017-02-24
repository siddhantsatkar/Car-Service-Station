/**
 * 
 */
package com.charlotte.carservice.model;

import java.util.List;

import com.charlotte.carservice.Beans.ServiceSlotBean;
import com.charlotte.carservice.dao.AdminDao;

/**
 * @author Pritam
 *
 */
public class Admin {
	private List<ServiceSlotBean> pendingServicingSlots;
	private List<ServiceSlotBean> finishedServicingSlots;
	/**
	 * @return the pendingServicingSlots
	 */
	public List<ServiceSlotBean> getPendingServicingSlots() {
		return pendingServicingSlots;
	}
	/**
	 * @param pendingServicingSlots the pendingServicingSlots to set
	 */
	public void setPendingServicingSlots(List<ServiceSlotBean> pendingServicingSlots) {
		this.pendingServicingSlots = pendingServicingSlots;
	}
	/**
	 * @return the finishedServicingSlots
	 */
	public List<ServiceSlotBean> getFinishedServicingSlots() {
		return finishedServicingSlots;
	}
	/**
	 * @param finishedServicingSlots the finishedServicingSlots to set
	 */
	public void setFinishedServicingSlots(List<ServiceSlotBean> finishedServicingSlots) {
		this.finishedServicingSlots = finishedServicingSlots;
	}
	
	public List<ServiceSlotBean> pendingServicings()
	{
		AdminDao adminDao=new AdminDao();
		pendingServicingSlots=adminDao.getPendingServicingSlots();
		finishedServicingSlots=adminDao.getFinishedServicingSlots();
		return pendingServicingSlots;
	}
	public boolean isStatusUpdated(ServiceSlotBean serviceslot) {
		// TODO Auto-generated method stub
		AdminDao adminDao=new AdminDao();
		//pendingServicingSlots=
		return adminDao.isStatusUpdated(serviceslot);
	}
	public boolean isInvoiceGenerated(ServiceSlotBean serviceslot) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
