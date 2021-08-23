sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("sn.covid19fnt.controller.Home", {
		onInit: function () {

		},


		refresh: function () {
			var url = '/api/';
			let that = this;
			$.ajax({
				url: url,
				success: function (result) {
					console.log(result)
				
					that.getView().getModel("scholars").setData(result)
				},
				error: function (e) {
					// log error in browser
					console.log(e.message);
				}
			});
		}
	});
});