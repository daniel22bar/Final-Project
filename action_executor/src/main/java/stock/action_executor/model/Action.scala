package stock.action_executor.model

case class Action(  brokerId: String,
                    companyId: String,
                    activity: String,
                    notificationId: String,
                    stockTicker: String,
                    amountOfStocks: Int,
                    stockPrice: Double,
                    totalPrice: Double,
                    timestamp: String )
