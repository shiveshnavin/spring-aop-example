sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/json/JSONModel",
	'sap/ui/core/BusyIndicator'
], function (Controller, JSONModel, BusyIndicator) {
	"use strict";

	return Controller.extend("sn.covid19fnt.controller.Home", {
		onInit: function () {
			this.refresh()
		},


		refresh: function () {
			BusyIndicator.show()
			var url = '/api/';
			let that = this;
			$.ajax({
				url: url,
				success: function (result) {
					console.log(result)
					BusyIndicator.hide();
					that.getView().setModel(new JSONModel(result), "scholars")
				},
				error: function (e) {
					BusyIndicator.hide()

					// log error in browser
					console.log(e.message);
				}
			});
		}
	});
});