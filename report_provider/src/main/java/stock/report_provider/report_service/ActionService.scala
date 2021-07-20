package stock.report_provider.report_service

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col
import org.springframework.stereotype.Component
import stock.report_provider.repo.ActionRepo

@Component
class ActionService (actionRepo: ActionRepo){
  def getAllActionByDateRange(startDate: String, endDate: String):DataFrame ={
    actionRepo.read.where(col("timeStamp").between(startDate.toString,endDate.toString))
  }
  def getAllActionBrokerId(brokerId:String): DataFrame ={
    actionRepo.read
      .where(col("brokerId")===brokerId)
  }
  def getAllActionByDateRangeAndBrokerId(startDate: String, endDate: String,brokerId:String):DataFrame={
    getAllActionByDateRange(startDate,endDate).where(col("brokerId")===brokerId)
  }
}
