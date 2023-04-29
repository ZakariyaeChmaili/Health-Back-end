from flask import Flask, request
import pandas as pd
import pickle
from flask_cors import CORS


app = Flask(__name__)
CORS(app)


@app.route('/ai', methods=['POST'])
def ai():
    # load the saved model from a file
    with open('knn_model.pkl', 'rb') as f:
        knn = pickle.load(f)

    # retrieve data from request body
    data = request.json
    print(data)
    blood_sugar = float(data['BloodSugar'])
    heart_beat = float(data['HeartBeat'])
    temperature = float(data['Temperature'])

    # create new data for prediction
    new_data = pd.DataFrame({'BloodSugar': [blood_sugar], 'HeartBeat': [heart_beat], 'Temperature': [temperature]})

    # make predictions using the loaded model
    prediction = knn.predict(new_data)

    print("Predicted Blood Pressure Rate:", prediction[0])

    return str(prediction[0])


if __name__ == '__main__':
    app.run()
