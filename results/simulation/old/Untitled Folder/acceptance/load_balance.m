d=load('/home/ah/Documents/home_network/results/simulation/acceptance/data/simple_accept','d')
m=load('/home/ah/Documents/home_network/results/simulation/acceptance/data/worst_accept','m')

dt=[d,m]
y=[1:1:5]

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
xlabel('flows bandwidth ranges','FontWeight','bold','FontSize',24);

% Create ylabel
ylabel('fraction of flows with internet access','FontWeight','bold','FontSize',24);
