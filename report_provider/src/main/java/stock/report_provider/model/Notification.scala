package stock.report_provider.model

import stock.report_provider.model.BrokerAction.BrokerAction

case class Notification(brokerId: String,
                        brokerFirstName: String,
                        activity:BrokerAction,
                        brokerLastName: String,
                        brokerCompany: String,
                        communicationTypeDetails: Nothing,
                        timeStamp: String,
                        stockInfo: Nothing )


