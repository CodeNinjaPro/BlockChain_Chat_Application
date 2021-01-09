# Python
import pandas as pd
from fbprophet import Prophet

df = pd.read_csv('example_retail_sales.csv')
df.head()

m = Prophet()
m.fit(df)

future = m.make_future_dataframe(periods=7)
future.tail()

forecast = m.predict(future)
forecast[['ds', 'yhat', 'yhat_lower', 'yhat_upper']].tail()

forecast.to_csv('PredictOutput.csv')