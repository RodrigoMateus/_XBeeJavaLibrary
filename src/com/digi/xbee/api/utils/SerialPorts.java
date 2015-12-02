package com.digi.xbee.api.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;

public class SerialPorts {

	public SerialPorts() {
		// TODO Auto-generated constructor stub
	}

	public static HashSet<CommPortIdentifier> getAvailableSerialPorts() {

		HashSet<CommPortIdentifier> hashSetCommPortId = new HashSet<CommPortIdentifier>();
		@SuppressWarnings("rawtypes")
		Enumeration enumerationPortIds = CommPortIdentifier.getPortIdentifiers();

		while (enumerationPortIds.hasMoreElements()) {

			CommPortIdentifier commPortId = (CommPortIdentifier) enumerationPortIds.nextElement();

			switch (commPortId.getPortType()) {

			case CommPortIdentifier.PORT_SERIAL:
				try {
					CommPort commPort = commPortId.open("CommUtil", 50);
					commPort.close();
					hashSetCommPortId.add(commPortId);
				} catch (PortInUseException e) {
					System.out.println("Port, " + commPortId.getName() + ", is in use.");
				} catch (Exception e) {
					System.err.println("Failed to open port " + commPortId.getName());
					e.printStackTrace();
				}
			}
		}
		return hashSetCommPortId;
	}

	public static List<String> getSerialPortList() {

		List<String> portList = new ArrayList<String>();
		@SuppressWarnings("rawtypes")
		Enumeration enumerationPortIds = CommPortIdentifier.getPortIdentifiers();

		while (enumerationPortIds.hasMoreElements()) {

			CommPortIdentifier commPortId = (CommPortIdentifier) enumerationPortIds.nextElement();

			switch (commPortId.getPortType()) {

			case CommPortIdentifier.PORT_SERIAL:
				try {
					CommPort commPort = commPortId.open("CommUtil", 50);
					commPort.close();
					portList.add(commPortId.getName());
				} catch (PortInUseException e) {
					// System.out.println("Port, " + commPortId.getName() + ", is in use.");
				} catch (Exception e) {
					// System.err.println("Failed to open port " + commPortId.getName());
					e.printStackTrace();
				}
			}
		}
		return portList;
	}

}
