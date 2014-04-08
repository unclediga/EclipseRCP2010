package org.eclipsercp.hyperbola;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipsercp.hyperbola.model.ContactsEntry;
import org.eclipsercp.hyperbola.model.ContactsGroup;

public class HyperbolaAdapterFactory implements IAdapterFactory {
	
	private IWorkbenchAdapter groupAdapter = new IWorkbenchAdapter() {
		
		@Override
		public Object getParent(Object o) {
			return ((ContactsGroup) o).getParent();		
		}
		
		@Override
		public String getLabel(Object o) {
			return ((ContactsGroup) o).getName();
		}
		
		@Override
		public ImageDescriptor getImageDescriptor(Object object) {
			return null;
		}
		
		@Override
		public Object[] getChildren(Object o) {
			return ((ContactsGroup) o).getEntries();
		}
	};
	
	private IWorkbenchAdapter entryAdapter = new IWorkbenchAdapter() {
		
		@Override
		public Object getParent(Object o) {
			return ((ContactsEntry)o).getParent();
		}
		
		@Override
		public String getLabel(Object o) {
			ContactsEntry entry = ((ContactsEntry)o);
			return entry.getName() + '-' + entry.getServer();		}
		
		@Override
		public ImageDescriptor getImageDescriptor(Object object) {
			return null;
		}
		
		@Override
		public Object[] getChildren(Object o) {
			return new Object[0];
		}
	};
	
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == IWorkbenchAdapter.class && adaptableObject instanceof ContactsGroup)
			return groupAdapter;
		else if(adapterType == IWorkbenchAdapter.class && adaptableObject instanceof ContactsGroup)
			return entryAdapter;
			
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[]{ IWorkbenchAdapter.class};
	}
}
