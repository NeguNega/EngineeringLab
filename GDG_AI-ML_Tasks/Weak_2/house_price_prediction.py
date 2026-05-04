# house_price_prediction.py

import os
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, mean_absolute_error

# Check if the CSV file exists
csv_file = "Housing.csv"
if not os.path.isfile(csv_file):
    print(f"Error: '{csv_file}' not found in the current folder.")
    print("Make sure the CSV file is in the same folder as this script.")
    exit()

# Load dataset
df = pd.read_csv(csv_file)

# Separate target and features
y = df['price']
X = df.drop('price', axis=1)

# Encode categorical variables
X = pd.get_dummies(X, drop_first=True)

# Split into training and testing sets (80% train, 20% test)
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=42
)

# Create and train Linear Regression model
model = LinearRegression()
model.fit(X_train, y_train)

# Predict on test set
y_pred = model.predict(X_test)

# Evaluation
mse = mean_squared_error(y_test, y_pred)
mae = mean_absolute_error(y_test, y_pred)

print("Mean Squared Error (MSE):", mse)
print("Mean Absolute Error (MAE):", mae)
print("\nFirst 10 Predictions vs Actual:")
for pred, actual in zip(y_pred[:10], y_test[:10]):
    print(f"Predicted: {pred:.2f}, Actual: {actual}")

# Predict price of a new house
new_house = {
    'area': 2000,
    'bedrooms': 4,
    'bathrooms': 3,
    'stories': 2,
    'mainroad': 'yes',
    'guestroom': 'no',
    'basement': 'yes',
    'hotwaterheating': 'no',
    'airconditioning': 'yes',
    'parking': 2,
    'prefarea': 'yes',
    'furnishingstatus': 'furnished'
}

# Convert to DataFrame and encode like before
new_df = pd.DataFrame([new_house])
new_df = pd.get_dummies(new_df, drop_first=True)

# Align columns with training data
new_df = new_df.reindex(columns=X_train.columns, fill_value=0)

predicted_price = model.predict(new_df)
print("\nPredicted price of the new house:", predicted_price[0])
