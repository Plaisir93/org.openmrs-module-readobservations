/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.plr.fragment.controller;

import org.openmrs.api.UserService;
import org.openmrs.api.ObsService;
import org.openmrs.Patient;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;

/**
 *  * Controller for a fragment that shows obs  
 */

public class ObservationsFragmentController {
	
	public void controller(FragmentModel model, @SpringBean("obsService") ObsService service) {
		
		String startString = "2019-03-6";
		String endString = "2019-03-7";
		
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
		
		Date startDate = new Date();
		Date endDate = new Date();
		try {
			startDate = format1.parse(startString);
			endDate = format2.parse(endString);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("observations",
		    service.getObservations(null, null, null, null, null, null, null, null, null, startDate, endDate, true));
	}
}
