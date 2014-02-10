
d=load('/home/ah/Documents/home_network/results/simulation/data/simple_loadlevel','d')
m=load('/home/ah/Documents/home_network/results/simulation/data/worst_loadlevel','m')
n=load('/home/ah/Documents/home_network/results/simulation/data/anealing_loadlevel','n')

dt=[d,m,n]
y=[1:1:3]

y=y'

% Create axes
figure1 = figure;

axes1 = axes('Parent',figure1,'MinorGridLineStyle','--',...
    'GridLineStyle','--',...
    'FontWeight','bold',...
    'FontSize',20);
 %ylim(axes1,[0 32]);

box(axes1,'on');
grid(axes1,'on');
hold(axes1,'all');

%plot1 = plot(y,s,'MarkerSize',10,'LineWidth',2);
%set(plot1(1),'Color',[1 0 0]);

plot2 = bar(y,dt,'BarWidth',1)
%set(plot2(1),'Color','r');

%plot2 = plot(y,d,'MarkerSize',10,'LineWidth',2);
%set(plot2(1),'Color','g');


% Create xlabel
xlabel('flows bandwidth range (Mbps)','FontWeight','bold','FontSize',24);

% Create ylabel
ylabel('load balancing level','FontWeight','bold','FontSize',24);

