package stock.report_provider.report_service

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col
import org.springframework.stereotype.Component
import stock.report_provider.repo.NotificationRepo

@Component
class NotificationService (notificationRepo: NotificationRepo){
  def getAllNotificationByDateRange(startDate: String, endDate: String): DataFrame ={
    notificationRepo.read.where(col("timeStamp").between(startDate.toString,endDate.toString))
  }
  def getAllNotificationBrokerId(brokerId:String): DataFrame ={
    notificationRepo.read
      .where(col("brokerId")===brokerId)
  }
  def getAllNotificationByDateRangeAndBrokerId(startDate: String, endDate: String,brokerId:String):DataFrame={
    getAllNotificationByDateRange(startDate,endDate).where(col("brokerId")===brokerId)
  }
}
