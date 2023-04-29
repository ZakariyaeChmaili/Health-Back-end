import pandas as pd
import pickle

# load the saved model from a file
with open('knn_model.pkl', 'rb') as f:
    knn = pickle.load(f)

# create new data for prediction
new_data = pd.DataFrame({'BloodSugar': [2.0], 'HeartBeat': [100], 'Temperature': [39]})

# make predictions using the loaded model
prediction = knn.predict(new_data)

print("Predicted Blood Pressure Rate:", prediction[0])
