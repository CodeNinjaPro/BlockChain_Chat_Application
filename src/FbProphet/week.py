import pandas as pd
import numpy as np
from fbprophet import Prophet

df = pd.read_csv('example_wp_log_peyton_manning.csv')
m = Prophet(changepoint_prior_scale=0.01).fit(df)
future = m.make_future_dataframe(periods=7, freq='H')
forecast = m.predict(future)
forecast[['ds', 'yhat', 'yhat_lower', 'yhat_upper']].tail()

forecast.to_csv('PredictOutput.csv')

fig1 = m.plot(forecast)
fig1.savefig('1.png')

fig2 = m.plot_components(forecast)
fig2.savefig('2.png')