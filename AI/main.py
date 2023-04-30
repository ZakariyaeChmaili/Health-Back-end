import pandas as pd
import pickle
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsRegressor
from sklearn.metrics import mean_squared_error

# load the json file that contains the health care data 
data = pd.read_json('data.json')

X = data[['BloodSugar', 'HeartBeat', 'Temperature']]
y = data['BloodPressure']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

knn = KNeighborsRegressor(n_neighbors=5)

knn.fit(X_train, y_train)

# save the trained model to a file
with open('knn_model.pkl', 'wb') as f:
    pickle.dump(knn, f)

# load the saved model from a file
with open('knn_model.pkl', 'rb') as f:
    knn = pickle.load(f)

y_pred = knn.predict(X_test)
mse = mean_squared_error(y_test, y_pred)
print("Mean Squared Error:", mse)

new_data = pd.DataFrame({'BloodSugar': [2.0], 'HeartBeat': [100], 'Temperature': [39]})

# make predictions using the loaded model
with open('knn_model.pkl', 'rb') as f:
    knn = pickle.load(f)
    
prediction = knn.predict(new_data)
print("Predicted Blood Pressure Rate:", prediction[0])
