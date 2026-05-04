# House Price Prediction using Linear Regression

This project predicts house prices using a **Linear Regression** model on a housing dataset. It includes preprocessing of categorical features and demonstrates predicting the price of a new house.

## Features

* Handles both numerical and categorical features.
* Encodes categorical features with `pd.get_dummies()`.
* Splits data into training (80%) and testing (20%) sets.
* Calculates **Mean Squared Error (MSE)** and **Mean Absolute Error (MAE)** to evaluate the model.
* Predicts the price of a new house given its attributes.

## Usage

1. Upload the `Housing.csv` dataset in Google Colab.
2. Run the notebook cells sequentially to train the model and test predictions.
3. Use the `new_house` dictionary to input a new house and get its predicted price.

