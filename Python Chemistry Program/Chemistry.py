## Imported Libraries needed
import numpy as np
import matplotlib as mpl
import matplotlib.pyplot as plt
import plotly as py
import plotly.graph_objects as go

print('''
Welcome to Equation Selection. Please type a number to pick the corresponding equation or type 'e' to exit.

1) Viral Equation of State

2) Soave-Redlich-Kwang Equation of State

3) The Compressibility- Factor Equation of State

4) Van der Waals Equation of State

5) The Clapeyron Equation
''')

while True:
    ans = input("What equation would you like to use? ")
    if ans == '1' :
        print("Viral Equation of State")
        print("\n")
        print("What you need to know about the Virial Equation of State:")
        print("This Equation can be used to solve for the Pressure or Volume that a given compound occupies/ has at a specific Temperature, Preassure and/or Volume")
        print("\n")
        print("IMPORTANT TO NOTE:")
        print("This equation CAN NOT be used for polar compounds (asymmetrical compounds with a non-zero dipole moment)")
        print("\n")
        print("Hence, the Pitzer Acentric Factor, which reflects the geometry and polarity of a molecule is taken into account in this equation")
        print("\n")
        print("Be sure to enter a compound that is non-polar, i.e, has a dipole moment of approximately zero")
        print("\n")        
        print("Do Enjoy!")
        print("\n")
        print("FOLLOW THE FOLLOWING STEPS TO SOLVE FOR YOUR SPECIFIC VOLUME OR PRESSURE")
        # Constants 
        R = 0.08206
        
#================= Functions for Equation 1 ========================================================================

                # Created a function called formulas which took P and T as arguments
                # P and T are pressure and temperature inputs from user 
        def formulas(P,T):
                    # Let variable Pr be equal to P divided by Pc(User input)
                    Pr = (P)/Pc
                    print("Your Reduced Pressure(Pr) value is: " + str(Pr) + "\n")


                    # Let Tr variable equal T divided by Tc
                    # This gave the Tr value 
                    Tr =  (T)/Tc
                    print("Your Reduced Temperature(Tr) value is: " + str(round(Tr,4)) + "\n")


                    # Let Bo variable equal equation of B initial
                    # Therefore , B initial is stored in variable Bo
                    Bo = 0.083 - ((0.422)/(Tr**1.6))
                    # Printed results rounded to 4 dec places
                    print("Your B initial(Bo) value is: " + str(round(Bo,4)))

                    # Let B1 variable equal equation of B1
                    # Therefore , B1 value is stored in variable B1
                    B1 = 0.139 - ((0.172)/(Tr**4.2))
                    print("Your B1 value is: " + str(round(B1,4)))

                    # Formula for B value 
                    # Calculated B value using an equation
                    # equation was 'B=RTc/Pc(Bo − ωB1)'
                    B = (R*Tc/Pc)*((Bo) + w*(B1))
                    print("Your B value is: " + str(round(B,4)) +'\n')

                    # Formula to calculate Volume
                    V = ((R*T)/(P)) + B
                    print("Your Volume is:  " + str(V)+ " L/mol" + "\n")

                # Created a fucntion called V_form2
                # Took 2 arguments, that being moles and volume of container
                # ..this was user input    
        def V_form2(moles, container_v):
                    # Let V2 equal to volume 
                    # Volume was container volume divided by number of moles
                    V2 = container_v/moles
                    print("Your volume is: " + str(V2)+ " L/mol")


                # Created a function called pressure
                # Function was a duplicate of formula function
                # The only difference in this fucntion is 
                # ..that it solves for pressure instead of volume

        def pressure(V,T):
                    
                    # Let Tr variable equal T divided by Tc
                    # This gave the Tr value 
                    Tr =  (T)/Tc
                    print("Your Reduced Temperature(Tr) value is: " + str(round(Tr,4)) + "\n")


                    # Let Bo variable equal equation of B initial
                    # Therefore , B initial is stored in variable Bo
                    Bo = 0.083 - ((0.422)/(Tr**1.6))
                    # Printed results rounded to 4 dec places
                    print("Your B initial(Bo) value is: " + str(round(Bo,4)))

                    # Let B1 variable equal equation of B1
                    # Therefore , B1 value is stored in variable B1
                    B1 = 0.139 - ((0.172)/(Tr**4.2))
                    print("Your B1 value is: " + str(round(B1,4)))

                    # Formula for B value 
                    # Calculated B value using an equation
                    # equation was 'B=RTc/Pc(Bo − ωB1)'
                    B = (R*Tc/Pc)*((Bo) + w*(B1))
                    print("Your B value is: " + str(round(B,4)) +'\n')

                    # Works out pressure via user input of V
                    # Returns pressure in a readable manner
                    pressure = R*T/V - B
                    print("Your Pressure (P) value is:  " + str(pressure)+ " atm")

                    # Worked out reduced pressure 
                    # Derived pressure variable from previous calculation
                    Pr = (pressure)/Pc
                    print("Your Reduced Pressure(Pr) value is: " + str(Pr) + "\n")

        #=========== Program =============================================================================================== 
                # Asked user for input / obtain compound name
        user_input = input("Enter the name of the compound: ")

                # Opened Tc_Pc.txt file to read and write 
                # as variable f
                # Used a for loop to iterate through the lines
        with open('Tc_Pc.txt', 'r+') as f:
                    for line in f:
                        # Separated the lines and stored as a list
                        # Used "," as a separator parameter
                        compound_list = line.split(",")
                        # If user input was equal to the compound name
                        # Values from that line would be assigned to Tc,Pc and w variables
                        # These variables will be used for calculations in the functions
                        if user_input == compound_list[0]:
                            Tc = float(compound_list[1])
                            Pc = float(compound_list[2])
                            w = float(compound_list[3])
                # Printed out values in an easy to read manner
        print(""" Your values are:
                                    Tc(K) = %s
                                    Pc(atm) = %s
                                    ω = %s
                        """ % (Tc,Pc,w))
                
                
                # Obtained user input of Pressure and Temperature
                # Stored as float variables
        v_or_p = input("Would you like to solve for Pressure or Volume? Type either 'Pressure' or 'Volume':  ")
        if v_or_p == 'Volume':
                    P = float(input("Please enter a Pressure value: "))
                    T = float(input("Please enter a Temperature value: "))

                    # Called formulas function
                    formulas(P,T)

                    # Obtained user input of moles and volume
                    # Called v_form2() fucntion 
                    print(" 'Calculating Volume with No. of Moles and Volume of Container' ")
                    moles = float(input("Please enter the number of moles: "))
                    container_v = float(input("Please enter the volume of the container: "))
                    V_form2(moles, container_v)

        elif v_or_p == 'Pressure':
                    V = float(input("Please enter a Volume(V) value: "))
                    T = float(input("Please enter a Temperature value: "))
                    pressure(V,T)
                    
        break
    
    
    elif ans == '2' :
        print("Soave-Redlich-Kwang (SKR) Equation of State")
        print("\n")
        print("The Soave-Redlich Kwang (SKR) Equation of state is one of the three cubic equations fo state.")
        print("This is because when expanded, it yields a third order equation for specific volume")
        print('\n')
        print('The SKR uses simplified mathematical formulas in order to describe a wide variety of systems.')
        print('In this programme, Pressure or Volume can be calculated at a given Temperature.')
        print('\n')
        print('Important points to note with this programme:')
        print('* All compounds name are case sensitive and are according to M.Felder & W.Rousseau: Elementary Principles of Chemical Processes')
        print('*Pressure units are in atm')
        print('*Temperature Units are in Kelvin(K)')
        print('*The gas constant used is 0.08206L.atm/K.mol')
        print('\n')
        print("FOLLOW THE FOLLOWING STEPS TO GENERATE YOUR OUTPUT:")

#========Functions for Equation 2=============#
        from math import sqrt
        R = 0.08206
        # Created a fucntion called pressure
        # Took T as param
        # Worked out Tr, a,b,m, alpha and pressure value
        def pressure(T):
        # Let Tr variable equal T divided by Tc
        # This gave the Tr value 
            Tr =  (T)/Tc
            print("Your Reduced Temperature(Tr) value is: " + str(round(Tr,4)) + "\n")

            # Calculation to get a value
            # Stored as variable 'a'
            a = (0.42747)*((R*Tc)**2)/(Pc)
            print("Your a value is: " + str(a) + "\n")

            # Calculation to get b value
            # Stored as variable 'b'
            b = (0.08664)*((R*Tc)/(Pc))
            print("Your b value is: " + str(b) + "\n")

            # Calculation to get m value
            # Stored as variable 'm'
            m = 0.48508 + (1.55171*w) - (0.1561*(w)**2)
            print("Your m value is: " + str(m) + "\n")
            
            # Calculation to get alpha value
            # Stored as variable 'alpha'
            alpha = (1+m*(1-sqrt(Tr))**2)
            print("Your alpha value is: " + str(alpha) + "\n")

            # Pressure formula
            # Variable called 'v_input' is equal to user input of V
            P = ((R*T)/(v_input - b)) - ((alpha*a)/(v_input*(v_input + b)))
            print("Your Pressure(P) value is = " + str(P) + "atm" + "\n")

        # Created a function called volume
        # Took T as param
        # Worked out Tr, a,b,m, alpha and volume value
        def volume(T):
        # Let Tr variable equal T divided by Tc
        # This gave the Tr value 
            Tr =  (T)/Tc
            print("Your Reduced Temperature(Tr) value is: " + str(round(Tr,4)) + "\n")

            # Calculation to get a value
            # Stored as variable 'a'
            a = (0.42747)*((R*Tc)**2)/(Pc)
            print("Your a value is: " + str(a) + "\n")

            # Calculation to get b value
            # Stored as variable 'b'
            b = (0.08664)*((R*Tc)/(Pc))
            print("Your b value is: " + str(b) + "\n")

            # Calculation to get m value
            # Stored as variable 'm'
            m = 0.48508 + (1.55171*w) - (0.1561*(w)**2)
            print("Your m value is: " + str(m) + "\n")
            
            # Calculation to get alpha value
            # Stored as variable 'alpha'
            alpha = (1+m*(1-sqrt(Tr))**2)
            print("Your alpha value is: " + str(alpha) + "\n")

            # Pressure formula
            # Variable called 'v_input' is equal to user input of V
            V = (-sqrt(((a**2)*(alpha**2)) - (6*a*b*alpha*R*T) + ((b**2)*(R**2)*(T**2))) + a*alpha - b*R*T)/(2*R*T)
            print("Your Volume(V) value is = " + str(V) + "L/mol " + "\n")


        user_input = input("Enter the name of a compound:")
        T = float(input("Please enter a Temperature Value: "))

        # Opened Tc_Pc.txt file to read and write 
        # as variable f
        # Used a for loop to iterate through the lines
        with open('Tc_Pc.txt', 'r+') as f:
            for line in f:
                # Separated the lines and stored as a list
                # Used "," as a separator parameter
                compound_list = line.split(",")
                # If user input was equal to the compound name
                # Values from that line would be assigned to Tc,Pc and w variables
                # These variables will be used for calculations in the functions
                if user_input == compound_list[0]:
                    Tc = float(compound_list[1])
                    Pc = float(compound_list[2])
                    w = float(compound_list[3])
        # Printed out values in an easy to read manner
        print(""" Your values are:
                            Tc(K) = %s
                            Pc(atm) = %s
                            ω = %s
                """ % (Tc,Pc,w))

        # Asked user for input 
        p_or_t = input("""Please type 'Volume' if you'd like to input a pressure value to solve for volume.
        Please type 'Pressure' if you'd like to input a volume value to solve for pressure.
                        """)
        # If user inputted 'Pressure', volume would be asked and pressure function called
        # In order to calculate pressure
        if p_or_t == 'Pressure':
            v_input = float(input("Please enter a Volume value: "))
            pressure(T)

        # If user inputted 'Volume', pressure would be asked and volume function called
        # In order to calculate volume
        elif p_or_t == 'Volume':
            p_input = float(input("Please enter a Pressure value: "))
            volume(T)
            
        break
        
    elif ans == '3' :
        print("""                      The Compressibility-Factor Equation of State

        The Compressibility Factor (Z) is a measure of the extent to which the gas is behaving nonideally.
        The value of Z depends upon the proximity of Temperature, Pressure to the critical Temperature 
        and Pressure(Tc & Pc)
        
        It follows the Law of Corresponding States, which states that the compressibility factor for any gas
        at a specific value of reduced temperature(T/Tc) and reduced Pressure has approxiametly the same values
        for all species.
        
        What does this program do?
        
        -This program estimates the compressibility factor for a given compound at specific T,P and/or mol
        -The program also calculates the ideal reduced volume value in order to eliminate the trial and 
         error approach needed with cubic eqautions of state
        -Allows each of access of calculating the compressibility for a given compound rather than refering 
         a compressibility chart.
        - The Z factor calculated from this program can assist the user in further calculations elsewhere
        """)   
        R = 0.08206
#====================Functions for Equation 3=================#
        def z1(P,T):
            V_spc = float(input("Please enter the Specific Volume(V̂): "))
            z = (P*V_spc)/(R*T)
            print("The compressibility factor (Z): " + str(z))
            
            Vr_ideal = (V_spc*Pc)/(R*Tc)
            print("Your reduced Ideal Volume for this compound at these conditions =" + str(Vr_ideal))

        def z2(P,T):
            moles = float(input("Please enter the number of moles: "))
            volume = float(input("Please enter the volume: "))
            z = (P*volume)/(moles*R*T)
            print("The compressibility factor (Z): " + str(z))

            Vr_ideal = (volume*Pc)/(R*moles*Tc)
            print("Your reduced Ideal Volume for this compound at these conditions =" + str(Vr_ideal))

        def Tr_and_Pr(P,T):
            Tr =  (T)/Tc
            print("Your Reduced Temperature(Tr) value is: " + str(round(Tr,4)) + "\n")
        
            Pr = (P)/Pc
            print("Your Reduced Pressure(Pr) value is: " + str(Pr) + "\n")


#=============Programme==============#
        # Opened 'Critical temp+pressure.txt' file to read and write 
        # as variable f
        # Used a for loop to iterate through the lines
        user_input = input("Please enter the name of a compound: ")
        with open('Critical temp+pressure.txt', 'r+') as f:
            for line in f:
                # Separated the lines and stored as a list
                # Used "," as a separator parameter
                compound_list = line.split(",")
                # If user input was equal to the compound name
                # Values from that line would be assigned to Tc,Pc and w variables
                # These variables will be used for calculations in the functions
                if user_input == compound_list[0]:
                    Tc = float(compound_list[1])
                    Pc = float(compound_list[2])
                    # Printed out values in an easy to read manner
        print(""" Your values are:
                            Tc(K) = %s
                            Pc(atm) = %s
                        
                """ % (Tc,Pc))

        P = float(input("Please enter a Pressure value(atm): "))
        T = float(input("Please enter the Temperature(K) of the system: "))
        Tr_and_Pr(P,T)

        formula_type = input("Is number of moles and volume known? Type either 'yes' or  'no': ")

        # Program
        if formula_type == 'no':
            z1(P,T)

        elif formula_type == 'yes':
            z2(P,T)
        break

    elif ans == '4' :
        print("Van der Waals Equation of State")
        print(""" The following example shows 2D Visualisation of Van der Waals Equation.
            Carbon Dioxide with the following properties were used:
               
                Tc = 304            # Critical temperature, K
                Pc = 73.6           # Pressure, Bar
                Pc = Pc*100000     # Converting pressure units, Pa
                R = 8.314           # Universal gas constant, (m3.Pa)/(mol.K)

                ######## Temperature Range ########
                T1, T2 = -50, 120                         # Start and end temperatures, °C
                T_step = 10                               # Step size, °C
                T = np.arange(T1+273.15,T2+273.15,T_step) # Discretisation and temperature conversion
                ######## Molar Volume Range ########
                V1, V2 = 0.00006, 0.001     # Start and end molar volume, m3
                V_step = 0.000001           # Step size, m3
                V = np.arange(V1,V2,V_step) # Discretisation
              """)
        
     
        ######## CO2 data ########
        Tc = 304            # Critical temperature, K
        Pc = 73.6           # Pressure, Bar
        Pc = Pc*100000     # Converting pressure units, Pa
        R = 8.314           # Universal gas constant, (m3.Pa)/(mol.K)

        ######## Temperature Range ########
        T1, T2 = -50, 120                         # Start and end temperatures, °C
        T_step = 10                               # Step size, °C
        T = np.arange(T1+273.15,T2+273.15,T_step) # Discretisation and temperature conversion
        ######## Molar Volume Range ########
        V1, V2 = 0.00006, 0.001     # Start and end molar volume, m3
        V_step = 0.000001           # Step size, m3
        V = np.arange(V1,V2,V_step) # Discretisation

        ######## Pressure Calculation ########
        def vdw(T,V):
            # Substance-specific constants
            a = (27*R**2*Tc**2)/(64*Pc)
            b = (R*Tc)/(8*Pc)
            P = np.zeros((len(T),len(V)))
            for i in range(0,len(T)):
                for j in range(0,len(V)):
                    P[i,j] = ((R*T[i])/(V[j]-b) - a/V[j]**2)/100000
                    # print(P)
            return P
        P_vdw = vdw(T,V)

        print(P_vdw)


#==============2D Visualisation===============#
        plt.figure(num=1, dpi=300)
        plt.rcParams["font.family"] = "serif"
        plt.rcParams['figure.facecolor'] = 'white'
        c = np.arange(1, len(T) + 1 )
        norm = mpl.colors.Normalize(vmin=c.min(), vmax=c.max())
        cmap = mpl.cm.ScalarMappable(norm=norm, cmap=mpl.cm.jet)
        cmap.set_array([])
        for i, yi in enumerate(P_vdw):
            plt.plot(V*1000, yi, c = cmap.to_rgba(i))
        plt.plot([0 , 0.001], [0, 0], 'k--') # zero line
        plt.plot((R*Tc)/Pc*1000,Pc/100000,'ko',markersize=6) # Critical point
        plt.xlim([0, 0.6])
        plt.ylim([P_vdw.min(),P_vdw.max()])
        cbar=plt.colorbar(cmap, ticks=c)
        # cbar.set_ticks(c)
        cbar.set_ticklabels(T)
        cbar.ax.set_yticklabels(["{:.0f}".format(i)+" " for i in T])
        cbar.ax.set_ylabel('Temperature ($K$)', weight="bold")
        plt.title("van der Waals Equation of State", weight="bold")
        plt.xlabel("Volume $(L)$", weight="bold")
        plt.ylabel("Pressure $(bar)$", weight="bold")
        plt.savefig('vdw.png')
        plt.show()
        break

    elif ans == '5' :
        print(""" The Clapeyron Equation:
              
        This equation can be used to estimate the vapour pressure of a given compound
        at specific experimental temperatures and pressures. 
        A plot of ln(p) and 1/T is shown illustrating the relationship between 
        pressure and temperature
        
        Please follow the following on-screen to estimate vapour pressure:
              """)
        
        import math
        import numpy as np
        import matplotlib.pyplot as plt
        #Asked user for compound name for reference
        compound = input("Please enter a compound name: ")

        # Obtained T1,T2,P1,P2 values
        # Stored as respective names and as float variables
        T1 = float(input("Please enter a T1 value: ")) 
        T2 = float(input("Please enter a T2 value: "))
        P1 = float(input("Please enter a P1 value: "))
        P2 = float(input("Please enter a P2 value: "))

        # Printed out formula with values substituted inside
        print("−∆Ĥv/R = ∆ln(%smmHg/%smmHg)/(1/%sK - 1/%sK" % (P2,P1,T2,T1))
        ## Solving for −∆Ĥv/R
        hv_R = (math.log(P2/P1))/((1/T2)-(1/T1))
        print("−∆Ĥv/R is = " + str(hv_R) + '\n')

        # Used an if statement
        # If hv_R was negative, it would be made positive
        # By multiplying with -1
        #In order to obtain absolute value
        if hv_R<0:
            hv_R = hv_R*-1

        ## Solving for B
        ## abs() returns variable as positive/absolute function
        print("B = ln(%s)+ %s(1/%s)" %(P1,hv_R,T1))
        B = math.log(P1) + ((hv_R)*(1/T1))
        print("B is = " + str(B) + '\n')

        #Solving for ln(p*)
        print("ln(p*) = −∆Ĥv/R + B")
        ln_p = -(hv_R) + B
        print("The estimated vapour pressure for %s is %s" %(compound,ln_p))

        # Inverted T1 and T2, to be used in graph
        Td1 = 1/T1 
        Td2 = 1/T2

        # Graph of ln(p*) vs 1/T
        # Set x and y limits
        x = np.arange(-1, T2)
        y = np.arange(-1, T2)

        # x is equal to hv_R
        # performed changes as per  -(hv_R) + B on x
        # To reflect on the graph
        plt.plot(y,-x+B)

        # Added labels
        plt.title("Graph to show ln(p*) vs 1/T")
        plt.xlabel("1/T")
        plt.ylabel("ln(p*)")

        # Plotted with gridlines
        plt.grid()
        plt.show()
        break

    elif ans == 'e':
        print("Thank you!")
        break
    else:
        print("Please Enter a Proper Input.")