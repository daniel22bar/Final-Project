package stock.report_provider.repo

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.springframework.stereotype.Component
import stock.report_provider.model.Action

@Component
class ActionRepo(spark:SparkSession) extends Repo {

  override def read: DataFrame = {
    val schema = org.apache.spark.sql.Encoders.product[Action].schema
    spark.read.schema(schema).json("Data/Actions.json")
  }
}
