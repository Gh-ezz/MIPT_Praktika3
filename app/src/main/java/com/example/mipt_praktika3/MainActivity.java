package com.example.mipt_praktika3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Constants for arithmetic operations
    private static final String OPERATION_ADD = "+";
    private static final String OPERATION_SUBTRACT = "-";
    private static final String OPERATION_MULTIPLY = "*";
    private static final String OPERATION_DIVIDE = "/";

    // UI Elements
    private TextView txtDisplay;

    // Calculator state variables
    private double firstOperand = 0;
    private double secondOperand = 0;
    private String currentOperation = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setButtonListeners();
    }

    private void initializeViews() {
        txtDisplay = findViewById(R.id.txtDisplay);
    }

    private void setButtonListeners() {
        // Number buttons
        findViewById(R.id.btnZero).setOnClickListener(v -> handleNumberInput("0"));
        findViewById(R.id.btnOne).setOnClickListener(v -> handleNumberInput("1"));
        findViewById(R.id.btnTwo).setOnClickListener(v -> handleNumberInput("2"));
        findViewById(R.id.btnThree).setOnClickListener(v -> handleNumberInput("3"));
        findViewById(R.id.btnFour).setOnClickListener(v -> handleNumberInput("4"));
        findViewById(R.id.btnFive).setOnClickListener(v -> handleNumberInput("5"));
        findViewById(R.id.btnSix).setOnClickListener(v -> handleNumberInput("6"));
        findViewById(R.id.btnSeven).setOnClickListener(v -> handleNumberInput("7"));
        findViewById(R.id.btnEight).setOnClickListener(v -> handleNumberInput("8"));
        findViewById(R.id.btnNine).setOnClickListener(v -> handleNumberInput("9"));

        // Decimal point
        findViewById(R.id.btnDecimal).setOnClickListener(v -> handleDecimalInput());

        // Arithmetic operation buttons
        findViewById(R.id.btnAdd).setOnClickListener(v -> handleOperation(OPERATION_ADD));
        findViewById(R.id.btnSubtract).setOnClickListener(v -> handleOperation(OPERATION_SUBTRACT));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> handleOperation(OPERATION_MULTIPLY));
        findViewById(R.id.btnDivide).setOnClickListener(v -> handleOperation(OPERATION_DIVIDE));
        findViewById(R.id.btnSqrt).setOnClickListener(v -> calculateSquareRoot());

        // Equals button
        findViewById(R.id.btnEquals).setOnClickListener(v -> calculateResult());

        // Additional operation buttons
        findViewById(R.id.btnClear).setOnClickListener(v -> clearAll());
        findViewById(R.id.btnClearEntry).setOnClickListener(v -> clearEntry());
        findViewById(R.id.btnBackspace).setOnClickListener(v -> handleBackspace());
        findViewById(R.id.btnSign).setOnClickListener(v -> changeSign());
    }

    private void handleNumberInput(String number) {
        String currentText = txtDisplay.getText().toString();

        if (isNewOperation || currentText.equals("0")) {
            txtDisplay.setText(number);
            isNewOperation = false;
        } else {
            txtDisplay.setText(currentText + number);
        }
    }

    private void handleDecimalInput() {
        String currentText = txtDisplay.getText().toString();

        if (isNewOperation) {
            txtDisplay.setText("0.");
            isNewOperation = false;
        } else if (!currentText.contains(".")) {
            txtDisplay.setText(currentText + ".");
        }
    }

    private void handleOperation(String operation) {
        if (!currentOperation.isEmpty() && !isNewOperation) {
            calculateResult();
        }

        firstOperand = getDisplayValue();
        currentOperation = operation;
        isNewOperation = true;
    }

    private void calculateResult() {
        if (currentOperation.isEmpty()) {
            return;
        }

        secondOperand = getDisplayValue();
        double result = 0;

        switch (currentOperation) {
            case OPERATION_ADD:
                result = firstOperand + secondOperand;
                break;
            case OPERATION_SUBTRACT:
                result = firstOperand - secondOperand;
                break;
            case OPERATION_MULTIPLY:
                result = firstOperand * secondOperand;
                break;
            case OPERATION_DIVIDE:
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    txtDisplay.setText("Error");
                    clearAll();
                    return;
                }
                break;
        }

        displayResult(result);
        firstOperand = result;
        currentOperation = "";
        isNewOperation = true;
    }

    private void calculateSquareRoot() {
        double value = getDisplayValue();
        if (value >= 0) {
            displayResult(Math.sqrt(value));
            isNewOperation = true;
        } else {
            txtDisplay.setText("Error");
            clearAll();
        }
    }

    private void clearAll() {
        txtDisplay.setText("0");
        firstOperand = 0;
        secondOperand = 0;
        currentOperation = "";
        isNewOperation = true;
    }

    private void clearEntry() {
        txtDisplay.setText("0");
        isNewOperation = true;
    }

    private void handleBackspace() {
        String currentText = txtDisplay.getText().toString();

        if (currentText.length() > 1 && !currentText.equals("0")) {
            txtDisplay.setText(currentText.substring(0, currentText.length() - 1));
        } else {
            txtDisplay.setText("0");
            isNewOperation = true;
        }
    }

    private void changeSign() {
        double value = getDisplayValue();
        displayResult(-value);
    }

    private double getDisplayValue() {
        String text = txtDisplay.getText().toString();
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void displayResult(double result) {
        if (result == (long) result) {
            txtDisplay.setText(String.format("%d", (long) result));
        } else {
            txtDisplay.setText(String.valueOf(result));
        }
    }
}