package stock.report_provider.repo

import org.apache.spark.sql.DataFrame

trait Repo {
    def read:DataFrame
}
